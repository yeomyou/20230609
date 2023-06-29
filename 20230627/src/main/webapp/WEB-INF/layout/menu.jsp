<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="border-end bg-white" id="sidebar-wrapper">
          <c:choose>
          <c:when test="${!empty logId }">
                   <div class="sidebar-heading border-bottom bg-light"> ${logName }</div>
          </c:when>
          <c:otherwise>
                   <div class="sidebar-heading border-bottom bg-light">손님</div>
          </c:otherwise>
          </c:choose>
          
          
       
          <div class="list-group list-group-flush">
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글목록</a>
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Overview</a>
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Events</a>
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
              <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
          </div>
      </div>