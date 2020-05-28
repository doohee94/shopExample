package com.example.demo.shop.service;

import com.example.demo.shop.entity.*;
import com.example.demo.shop.entity.dto.MemberDto;
import com.example.demo.shop.entity.dto.OrderDto;
import com.example.demo.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final MemberRepository memberRepository;
    private final AlbumRepository albumRepository;
    private final BookRepository bookrepository;
    private final MovieRepository movieRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final DeliverRepository deliverRepository;
    private final OrderItemRepository orderItemRepository;

    public void signUp(MemberDto memberDto) {

        //이름 중복 체크
        MemberEntity memberEntity = memberRepository.findByName(memberDto.getName());
        if (memberEntity != null) throw new IllegalStateException("이름 중복");
        memberRepository.save(memberDto.toEntity());
    }

    public List<MemberEntity> memberList() {
//        return memberRepository.findAllJoinFetch(); // inner join
        return memberRepository.findAllEntityGraph(); // outer join
    }

    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void createAlbum(Album album) {
        albumRepository.save(album);
    }

    public void createBook(Book book) {
        bookrepository.save(book);
    }

    public List<ItemEntity> itemList() {
        return itemRepository.findAllEntityGraph();
    }

    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }

    public void createOrders(List<OrderDto> orderDtos, Address address) throws Exception {

        MemberEntity memberEntity = memberRepository.findById(3L).orElseThrow(NullPointerException::new);

        List<OrderItemEntity> orderItemEntities = new ArrayList<>();
        for (OrderDto orderDto : orderDtos) {
            ItemEntity entity = itemRepository.findById(orderDto.getItemId()).orElseThrow(NullPointerException::new);
            entity.removeStock(orderDto.getCount()); //따로 save를 하지 않아도 영속성 컨텍스트에 남아있어서 커밋될때 수정사항이 반영됨

            OrderItemEntity temp = OrderItemEntity.builder().count(orderDto.getCount()).itemEntity(entity).build();
            orderItemEntities.add(temp);
        }

        DeliveryEntity deliveryEntity = DeliveryEntity.builder().address(address).build(); //객체 생성 후 밑에서 save 할 때 1:1 관계라서 같이 save..?

        orderRepository.save(OrderEntity.builder()
                .memberEntity(memberEntity)
                .deliveryEntity(deliveryEntity)
                .orderItemEntities(orderItemEntities)
                .build());

    }

    public void cancelOrders(Long orderId) throws Exception {

        //일단 딜리버리가 완료면 취소 ㄴㄴ
        // item 에 취소된 수량만큼 +++
        //order 상태에 cancel 넣어주깅
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(NullPointerException::new);
        orderEntity.checkDeliveryStatus();
        orderEntity.setOrderStatus(OrderStatus.CANCEL);

        List<OrderItemEntity> orderItemEntities = orderItemRepository.findByOrderId(orderId);

        for (OrderItemEntity entity : orderItemEntities) {
            ItemEntity temp = entity.getItemEntity();
            temp.addStock(entity.getCount());
            entity.setItemEntity(temp);
        }

        orderItemRepository.saveAll(orderItemEntities);
    }

    public OrderEntity orderContent(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(NullPointerException::new);
    }

    public int checkPrice(Long orderId) {

        // 1. 쿼리로 만들어서 count 불러오기
        return orderItemRepository.checkPrice(orderId);

        //2. 해당 list 불러와서 더해주는 for문 짜기..
//        List<OrderItemEntity> orderItemEntity = orderItemRepository.findByOrderId(orderId);
//
//        int price = 0;
//        for(OrderItemEntity entity : orderItemEntity){
//            price += entity.getOrderPrice();
//        }
//        return price;

    }

    public List<OrderEntity> orderListByStatus(OrderStatus status) {

        return orderRepository.findByOrderStatus(status);
    }
}
