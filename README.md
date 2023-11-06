# AnonymousBoard
키워드 ( 제목, 작성자명, 비밀번호, 작성내용, 작성일)

키워드를 저장하고 ** 받환받을때는 비밀번호 제외

비밀번호 다를때 Status Code, Error, 메세지 반환 ( 비밀번호가 잘못 되었습니다 )

entity 말고 dto로 반환 ( json 쓰는거에 익숙해지기)

Use Case Diagram 그려보기!


API 명세서 작성하기! ------------------------------------

기능(메소드)     - url 	    -  response    -  request 				

생성(post)       -  /api/post	   	-  게시글작성 -  { 제목,작성자명,작성내용,작성일,비밀번호}

목록(get)        -  /api/get	   -  게시글목록  					

조회(get)        -  /api/get/{id}  -  게시글조회   					

수정(put)        -  /api/put/{id}  -  게시글수정  -  { 제목,작성자명,비밀번호}		

삭제(delete)     -  /api/delete/{id}   -  게시글삭제  -  { 제목,작성자명,비밀번호}		

/{id} 이건 @PathVariable 을 사용함

Dto - 다른 기능없이 순수 java클래스를 만들때 클래스명Dto 로 만듬

RequestDto - 요청

ResponseDto - 응답


ERD 작성하기! ------------------------------------

E (Entity. 개체) :
  1. 게시글 구현 (post) : 
  입력값	- id, 제목, 작성자명, 작성내용, 작성일, 비밀번호
  return	- id, 제목, 작성자명, 작성내용, 작성일, 비밀번호

  2. 게시글 목록 구현(get) :
  입력값	- list(제목,작성자명,작성내용,작성일,비밀번호)
  return	- 제목, 작성자명, 작성일 + ( 선택사항 : 작성내용 )

  3. 게시글 조회 구현 (get) :
  입력값	- id, 비밀번호
  return	- 제목, 작성자명, 작성내용, 작성일

  4. 게시글 수정 구현 (put) :
  입력값	- id, 비밀번호
  return	- set ( 작성내용, 작성일 ) + ( 선택사항 : 제목 )

  5. 게시글 삭제 구현 (delete) :
  입력값	- id, 비밀번호
  return	- remove ( 제목, 작성자명, 작성내용, 작성일, 비밀번호 )


A (Attribute. 속성) :
  - 제목
  - 작성자명
  - 작성내용
  - 작성일
  - 비밀번호


R (Relationship. 관계) :
  - 2(목록) <-> 3(생성)
  - 2(목록) -> 4(조회) -> 5,6(수정,삭제) -> 2(목록)


entity -> Board 
controller -> BoardController
dto -> BoardResponseDto, BoardRequestDto




API 테스트 하기! ------------------------------------
