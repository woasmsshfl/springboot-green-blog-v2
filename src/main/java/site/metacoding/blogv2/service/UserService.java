package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.UserRepository;

// 컴포넌트 스캔시에 IoC 컨테이너에 등록됨
// 트랜잭션(일의처리단위)을 관리하는 오브젝트 (기능들을 모아놓는다.)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
}
