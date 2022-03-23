// 1. 이벤트 리스너
$('#btn-join').click(() => {
  join();
});

$('#btn-login').click(() => {
  login();
});

// 2. 기능

// username 기억하기 메서드
// HttpOnly 속성이 걸려있으면 안된다!
function usernameRemember() {
  let cookies = document.cookie.split('=');
  $('#username').val(cookies[1]);
}
usernameRemember();

// 회원가입 요청 메서드
async function join() {
  // (1) username, password, email, addr 을 찾아서 오브젝트로 만든다.
  let joinDto = {
    username: $('#username').val(),
    password: $('#password').val(),
    email: $('#email').val(),
    addr: $('#addr').val(),
  };

  // (2) fetch 요청한다. (json으로 변환해서)
  let response = await fetch('/join', {
    method: 'POST',
    body: JSON.stringify(joinDto),
    headers: {
      'Content-Type': 'application/json; charset=utf-8',
    },
  });
  let responseParse = await response.json();
  console.log(responseParse);

  // (3) 회원가입이 잘되면 알림창 띄우고 로그인 페이지로 이동한다.
  if (responseParse.code == 1) {
    alert('회원가입완료');
    location.href = '/loginForm';
  } else {
    alert('회원가입실패');
  }
}

// 로그인 요청 메서드
async function login() {
  // JQuery에서 checkbox의 체크 여부를 true, false로 확인함.
  let checked = $('#remember').is(':checked');
  console.log(checked);

  let loginDto = {
    username: $('#username').val(),
    password: $('#password').val(),
    remember: checked ? 'on' : 'off', // 삼항연산자. checked가 true 면 on, false면 off 로 만들어준다.
  };

  console.log(loginDto);

  let response = await fetch('/login', {
    method: 'POST',
    body: JSON.stringify(loginDto),
    headers: {
      'Content-Type': 'application/json; charset=utf-8',
    },
  });
  let responseParse = await response.json();
  console.log(responseParse);

  if (responseParse.code == 1) {
    alert('로그인완료');

    location.href = '/';
  } else {
    alert('로그인실패');
  }
}
