package com.ados.xbook.controller.publicCtrl;

import com.ados.xbook.controller.BaseController;
import com.ados.xbook.domain.response.base.BaseResponse;
import com.ados.xbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/category")
public class PublicCategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public BaseResponse findAll(@RequestParam(value = "key", required = false) String key,
                                @RequestParam(value = "value", required = false) String value,
                                @RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "size", required = false) Integer size) {

        BaseResponse response;

        log.info("=>findAll key: {}, value: {}, page: {}, size: {}",
                key, value, page, size);

        response = categoryService.findAll(key, value, page, size);

        log.info("<=findAll key: {}, value: {}, page: {}, size: {}, res: {}",
                key, value, page, size, response);

        return response;

    }

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable(name = "id") Long id) {

        BaseResponse response;

        log.info("=>findById");

        response = categoryService.findById(id);

        log.info("<=findById");

        return response;

    }

    @GetMapping("/slug/{slug}")
    public BaseResponse findBySlug(@PathVariable(name = "slug") String slug) {

        BaseResponse response;

        log.info("=>findBySlug");

        response = categoryService.findBySlug(slug);

        log.info("<=findBySlug");

        return response;

    }

}
