package store.kanggyeonggu.api.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import store.kanggyeonggu.api.common.domain.Messenger;
import store.kanggyeonggu.api.product.domain.ProductDTO;
import store.kanggyeonggu.api.product.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public String save(ProductDTO product, Model model) {
        Messenger messenger = productService.save(product);
        model.addAttribute("messenger", messenger);
        return "product/list";
    }

    @PostMapping("/all")
    public String saveAll(@RequestParam("file") MultipartFile file, Model model) {
        Messenger messenger = null;
        model.addAttribute("messenger", messenger);
        return "product/list";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        List<ProductDTO> savedProducts = productService.getAllSavedProducts();
        model.addAttribute("products", savedProducts);
        return "product/list";
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable String id, Model model) {
        Messenger messenger = productService.findById(id);
        model.addAttribute("messenger", messenger);
        return "product/detail";
    }

    @PutMapping("{id}")
    public String update(ProductDTO product, Model model) {
        Messenger messenger = productService.update(product);
        model.addAttribute("messenger", messenger);
        return "product/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id, Model model) {
        Messenger messenger = productService.delete(id);
        model.addAttribute("messenger", messenger);
        return "product/list";
    }

}
