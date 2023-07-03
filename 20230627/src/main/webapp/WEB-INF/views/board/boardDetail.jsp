<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">

	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>

	<tbody>

		<tr>
			<td>${board.brdNo }</td>
			<td>${board.brdTitle }</td>
			<td>${board.brdWriter }</td>
			<td>${board.createDate }</td>
			<td>${board.clickCnt }</td>
		</tr>
		<tr>
			<td><textarea id="content" name="content">${board.brdContent }</textarea></td>
		</tr>

	</tbody>

</table>
<hr>
<!-- 댓글시작부분 -->
<div class="row" style="width: 85%; margin: 0 auto 0;">
	<div class="col-lg12">
		<div class="panel panel-default">
			<!--heading-->
			<div class="panel-heading" style="height: 40px;">
				<i class="fa fa-comments fa-fw"></i>Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
					New Reply</button>
			</div>
			<!-- body-->
			<div class="panel-body">
				<ul class="chat">
					<!-- <li class="left clearfix">
						<div>
							<div class="header">
								<strong class="primary-font">user1</strong> <small
									class="pull-right text-muted">2023-06-05 13:38</small>

								<p>Sample!!!!!@@@</p>
							</div>
						</div>
					</li>
					<li class="left clearfix">
						<div>
							<div class="header">
								<strong class="primary-font">user2</strong> <small
									class="pull-right text-muted">2023-06-07 15:58</small>

								<p>Hello</p>
							</div>
						</div>
					</li> -->
				</ul>
			</div>
			<!--footer-->
			<div class="panel-footer"></div>
		</div>
	</div>
</div>
<!-- 댓글종료부분 -->
<!-- 모달창 시작-->
<div class="modal fade" id="myModal" style="top: 200px;">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- header-->
			<div class="modal-header">
				<button class="close" id="modalCloseBtn1">&times;</button>
				<h4 class="modal-title">Reply Modal</h4>
				<input type="hidden" name="replyNo">
			</div>
			<!-- body -->
			<div class="modal-body">
				<div class="form-group">
					<label for="">Reply</label> <input class="form-control"
						name="reply" value="New reply...">
				</div>
				<div class="form-group">
					<label for="">Replyer</label> <input class="form-control"
						name="replyer" value="user1">
				</div>
				<div class="form-group">
					<label for="">Reply Date</label> <input class="form-control"
						name="replyDate" value="2023:06:30 11:52">
				</div>
			</div>
			<!-- footer -->
			<div class="modal-footer">
				<button id="modalModBtn" class="btn btn-warning">Modify</button>
				<button id="modalRemoveBtn" class="btn btn-danger">Remove</button>
				<button id="modalRegisterBtn" class="btn btn-primary">Register</button>
				<button id="modalCloseBtn" class="btn btn-secondary">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- 모달창 종료-->

<script>
	//등록버튼
	let modal = document.querySelector('#myModal'); 
	document.querySelector('#addReplyBtn').addEventListener('click', function(e){
		modal.style.display = 'block';
		modal.style.opacity = 1;
		//수정 삭제 숨김
		document.querySelector('#modalRemoveBtn').style.display = 'none';
		document.querySelector('#modalRegisterBtn').style.display = 'block';
		document.querySelector('#modalModBtn').style.display = 'none';
		//등록날짜 항목 숨김.
		document.querySelector('#myModal div.modal-body div.form-group:nth-child(3)').style.display = 'none';
	})
	//조회


	//모달창 닫기
	document.querySelector('#modalCloseBtn').addEventListener('click', function(e){
		modal.style.display = 'none';
		modal.style.opacity = 0;
	})
	document.querySelector('#modalCloseBtn1').addEventListener('click', function(e){
		modal.style.display = 'none';
		modal.style.opacity = 0;
	})

	function makeList(reply = {}){
		// <li class="left clearfix">
		// 				<div>
		// 					<div class="header">
		// 							<strong class="primary-font">user1</strong>
		// 							<small class="pull-right text-muted">2023-06-05 13:38</small>

		// 						<p>Sample!!!!!@@@</p>
		// 					</div>
		// 				</div>
		// 			</li> 

		let str = '';
		str += '<li class="left clearfix" data-rno='+reply.replyNo+'><div><div class="header">';
		str += '<strong class="primary-font">'+reply.replyer+'</strong>';
		str += '<small class="pull-right text-muted">'+reply.replyDate+'</small></div>';
		str += '<p>'+reply.reply+'</p></div></li>';
		
		return str;
	}
	function searchList(){
		document.querySelectorAll('ul.chat li').forEach(function(tag){
			tag.addEventListener('click', function(e){
			modal.style.display = 'block';
			modal.style.opacity = 1;
			
			document.querySelector('#modalModBtn').style.display = 'block';
			document.querySelector('#modalRemoveBtn').style.display = 'block';
			document.querySelector('#modalRegisterBtn').style.display = 'none';
			
			let rno = tag.dataset.rno;
			fetch('getReply.do?rno='+rno)
//			.then(function(response){
//				return response.json()
//			})
			.then((response) => response.json())
			.then(function(result){
				document.querySelector('#myModal input[name="replyNo"]').value = result.replyNo;
				document.querySelector('#myModal input[name="reply"]').value = result.reply;
				document.querySelector('#myModal input[name="replyer"]').value = result.replyer;
				document.querySelector('#myModal input[name="replyDate"]').value = result.replyDate;
			})//then
			.catch(function(err){
				console.log(err);
			})//catch
			}) //tag.addEvent.function
		})//SelectorAll.function
	}// searchList


	//댓글목록 리스트 보여주기
	const bno = '${board.brdNo}';
	console.log(bno);
	const replyUL = document.querySelector('ul.chat');
	
	
	// 댓글목록 (Ajax)
	function replyFnc(bno, page){

		fetch('replyList.do?brdNo='+bno+'&page='+page )
		.then(function(response){
			//console.log(response);
			return response.json();
		})
		.then(function(result){
			//console.log(result); 
			if(page == -1) {
				pageNum = Math.ceil(result.count / 10.0);
				replyFnc(bno,pageNum);
				return;
			}
			//기존 데이터 초기화
			replyUL.innerHTML = "";
			for(let reply of result.list){
				replyUL.innerHTML += makeList(reply);
			}
			searchList();
			showReplyPage(result.count);
	
		})
		.catch(function(err){
			console.log(err);
		})
	}
	replyFnc(bno,-1); //첫페이지 출력.
	
	//수정버튼 클릭
	document.querySelector('#modalModBtn').addEventListener('click', function(e){
		//modal 의값으로 Controller 접근.
		let rno = document.querySelector('#myModal input[name="replyNo"]').value;
		let reply = document.querySelector('#myModal input[name="reply"]').value;
		
		fetch('modifyReply.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'rno='+rno+'&reply='+reply
		})
		.then(response => response.json())
		.then(result =>{
			console.log(result)
			let replyNo = result.replyNo;
			console.log(replyNo)
			let targetLi = document.querySelector('.chat li[data-rno="' + replyNo + '"]');
			targetLi.querySelector('p').innerText = result.reply;
			//modal 닫기
			modal.style.display = 'none';
			modal.style.opacity = 0;
		})
		.catch(err=>console.error(err))
	})
	
	//삭제버튼 클릭.
	document.querySelector('#modalRemoveBtn').addEventListener('click', function(e){
	let rno = document.querySelector('#myModal input[name="replyNo"]').value;
		fetch('removeReply.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'rno='+rno
		})
		.then(response =>response.json())
		.then(result =>{
			//console.log(result);
			let targetLi = document.querySelector('.chat li[data-rno="' + rno + '"]');
			targetLi.remove();
			replyFnc(bno, pageNum);
			//searchList();
			modal.style.display = 'none';
			modal.style.opacity = 0;
		})
		.catch(err=>console.error(err))
	})
	document.querySelector('#modalRegisterBtn').addEventListener('click', function(e){
		let replyer = document.querySelector('#myModal input[name="replyer"]').value;
		let brdNo = ${board.brdNo};
		let reply = document.querySelector('#myModal input[name="reply"]').value;
		console.log(brdNo)
		//let rno = document.querySelector('#myModal input[name="replyNo"]').value;
		fetch('addReply.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'bno=' + brdNo + '&reply=' + reply + '&replyer=' + replyer
		})
		.then(response => response.json())
		.then(result =>{
			//replyUL.innerHTML += makeList(obj);
			//searchList();
			replyFnc(bno,-1);
			modal.style.display = 'none';
			modal.style.opacity = 0;
		})
		.catch(err=>console.error(err))
	})
	let pageNum = 1;
	//댓글 갯수를 기준으로 페이지계산
	function showReplyPage(replyCnt){
		let endPage = Math.ceil(pageNum / 10.0) * 10;
		let startPage = endPage - 9;
		let prev = startPage != 1;
		let next = false;
		
		if( endPage * 10 > replyCnt){
			endPage = Math.ceil(replyCnt/ 10.0);
		}
		if(endPage *10 < replyCnt){
			next = true;
		}
		
		//계산한 값으로 페이지 출력.
		let str = '<ul class="pagination pull-right">';
		if(prev){
			str += '<li class="page-item"><a data-page="'+(startPage-1)+'" class="paging"> Prev </a></li>';
		}
		for(let i=startPage; i<=endPage; i++){
			str += '<li class="page-item"><a data-page="'+ i +'"class="paging">'+ i +'</a></li>';
		}
		if(next){
			str += '<li class="page-item"><a data-page="'+(endPage+1)+'"class="paging"> Next </a></li>';
		}
		str += '</ul>';
		document.querySelector('div.panel-footer').innerHTML = str;
		
		//링크 클릭 이벤트
		document.querySelectorAll('a.paging').forEach(aTag=>{
			aTag.addEventListener('click', function(e){
				e.preventDefault();
				pageNum = aTag.dataset.page;
				replyFnc(bno, pageNum); // 원본글, 페이지 호출.
				
			})
		})
	}
	//showReplyPage(156);
</script>