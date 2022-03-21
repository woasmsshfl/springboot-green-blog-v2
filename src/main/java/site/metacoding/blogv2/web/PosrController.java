package site.metacoding.blogv2.web;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.PostService;

@RequiredArgsConstructor
@Controller
public class PosrController {
    private final PostService postService;
}
