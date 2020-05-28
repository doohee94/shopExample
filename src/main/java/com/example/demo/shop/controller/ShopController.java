package com.example.demo.shop.controller;

import com.example.demo.shop.entity.*;
import com.example.demo.shop.entity.dto.MemberDto;
import com.example.demo.shop.entity.dto.OrderDto;
import com.example.demo.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    //회원가입
    @PostMapping(value = "/user/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody MemberDto memberDto) {
        shopService.signUp(memberDto);
    }

    //회원목록
    @GetMapping(value = "/user/list")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberEntity> memberList() {
        return shopService.memberList();
    }

    //책 상품 등록
    @PostMapping(value = "/item/book/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        shopService.createBook(book);
    }

    //앨범 상품 등록
    @PostMapping(value = "/item/album/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlbum(@RequestBody Album album) {
        shopService.createAlbum(album);
    }

    //영화 상품 등록
    @PostMapping(value = "/item/movie/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody Movie movie) {
        shopService.createMovie(movie);
    }

    //상품 리스트 - ALL  -> 나중에 세개로 나눠...
    @GetMapping(value = "/item/list")
    public List<ItemEntity> listTest(){
        return shopService.itemList();
    }

    //상품수정 - create랑 똑같은데.. 음..
    @PutMapping(value = "/item/update")
    public void updateAlbum(@RequestBody Album album){
        shopService.updateAlbum(album);
    }

    //상품 주문
    @PostMapping(value = "/orders/create")
    public void createOrders(@RequestBody List<OrderDto> orderDtos, Address address) throws Exception{
        shopService.createOrders(orderDtos, address);
    }

    //주문 취소
    @PutMapping(value = "/orders/cancel")
    public void cancelOrders(Long orderId) throws Exception {
        shopService.cancelOrders(orderId);
    }


    //주문 Id로 주문햇던 리스트 가져오기
    @GetMapping(value = "/orders/orderContent")
    public OrderEntity orderContent(Long orderId){
        return shopService.orderContent(orderId);
    }

    //주문 id 총 금액 확인
    @GetMapping(value = "/orders/check-price")
    public int checkPrice(Long orderId){
        return shopService.checkPrice(orderId);
    }

    //주문 상태별 주문 리스트
    @GetMapping(value = "/orders/list-by-status")
    public List<OrderEntity> orderListByStatus(OrderStatus status){
        return shopService.orderListByStatus(status);
    }


}
