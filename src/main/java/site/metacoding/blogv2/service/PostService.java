package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.post.PostRepository;

// 웹 브라우저 -> 컨트롤러 -> 서비스 -> 레파지토리 -> 영속성컨텍스트 -> 디비
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }
}
