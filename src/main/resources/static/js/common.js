// 1. 로그아웃 이벤트 리스너
$('#btn-logout').click(() => {
  logout();
});

// 2. 로그아웃 기능
async function logout() {
  let response = await fetch('/logout');
  let responseParse = await response.json();

  if (responseParse.code == 1) {
    location.href = '/';
  }
}
