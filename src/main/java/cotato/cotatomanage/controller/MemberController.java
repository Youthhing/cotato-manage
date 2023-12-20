package cotato.cotatomanage.controller;

import cotato.cotatomanage.domain.dto.JoinMemberRequest;
import cotato.cotatomanage.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> createMember(@RequestBody JoinMemberRequest request) {
        log.info("회원 가입 요청 : {}", request.getName());
        memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}