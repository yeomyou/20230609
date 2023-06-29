<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="boot-simple/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <tiles:insertAttribute name="menu"/>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
            
                <!-- Top navigation-->
                <tiles:insertAttribute name="header"/>
                
                <!-- Page content-->
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
    </body>
</html>
