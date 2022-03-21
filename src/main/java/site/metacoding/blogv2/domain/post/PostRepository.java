package site.metacoding.blogv2.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository는 무조건 interface로 한다.
public interface PostRepository extends JpaRepository<Post, Integer> {

}
