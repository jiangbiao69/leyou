package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller //把当前对象注入spring容器中
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
     * 根据父节点的id查询子节点
     * */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam("pid") Long pid){

        if(pid==null || pid<0){
            //400:参数不合法
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); /*不够简单*/
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST); /*可以更简单*/
            return ResponseEntity.badRequest().build();

        }
        List<Category> categories=this.categoryService.queryCategoriesByPid(pid);
        if(CollectionUtils.isEmpty(categories)){ //判断一个集合是否为空
            //404：资源服务器未找到
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); /*简化书写，如下*/
            return ResponseEntity.notFound().build();
        }
        //200：查询成功
        return ResponseEntity.ok(categories);
    }

    @GetMapping
    public ResponseEntity<List<String>> queryNamesByIds(@RequestParam("ids")List<Long> ids){
        List<String> names = this.categoryService.queryNamesByIds(ids);
        if(CollectionUtils.isEmpty(names)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(names);
    }

}
