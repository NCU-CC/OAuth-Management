<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp"></jsp:include>

        <!-- start:main -->
        <div class="container">
            <div id="main">
                <!-- start:breadcrumb -->
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Oauth</a></li>
                    <li class="active">Terms of Service and Privacy Policy</li>
                </ol>
                <!-- end:breadcrumb -->

                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="page-header">
                            Terms of Service and Privacy Policy
                        </h2>
                    </div>
                </div>

                <!-- start:invoice -->
                <div class="row invoice">
                    <div class="col-lg-12">
                        <div class="invoice-main">
                            <div class="invoice-head">
                                <div class="text-center">
                                    <h1><i class="fa fa-cubes"></i> <strong>NCU</strong>APP<strong>.</strong></h1>
                                </div>
                            </div>
                            <div class="invoice-body">
                                <div class="well well-lg">
                            <h3><strong>NCU</strong>APP<strong>.</strong> 服務條款</h3>
                            ${signText}
                             </div>
                            </div>
                            <div class="invoice-footer">
                                <div class="text-center">
                                    <a href="actived" class="btn btn-primary"><i class="fa fa-mail-forward"></i>I agree to the Terms of Service and Privacy Policy</a>                                    
                                </div>
                            </div>
                        </div>

                        <div class="footer-invoice">
                            <div class="row">
                                <div class="col-md-4">
                                    <h4>中央大學</h4>
                                    <hr>
                                                                                                                             中央大學 <br>
                                    (32001)桃園縣中壢市中大路300號 <br>
                                                                                                                             總機電話：03-4227151<br>
                                </div>
                                <div class="col-md-4">
                                    <h4>電子計算機中心</h4>
                                    <hr>
                                                                                                                             電子計算機中心 <br>
                                    (32001)桃園縣中壢市中大路300號<br>
                                                                                                                            電話 ： 03-4227151 (分機轉 57555/57500/57511)<br>
                                </div>
                                <div class="col-md-4">
                                    <h4>簽署狀態</h4>
                                    <hr>
                                                                                                                                簽屬 版本 : #${userSignVersion}<br>
                                                                                                                            簽署日期     : ${userSignDate}<br>
                                   <s:if test="userSignVersion==singVersion">
                                                                                                                            最新簽署   : <span class="label label-success">已簽署</span>
                                   </s:if>
                                   <s:else>
                                                                                                                            最新簽署   : <span class="label label-danger">未簽署</span>
                                   </s:else>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end:invoice -->

            </div>
        </div>
        <!-- end:main -->

       <jsp:include flush="true" page="footer.jsp"></jsp:include>

    <!-- start:javascript -->
    <!-- javascript default for all pages-->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- javascript for Srikandi admin -->
    <script src="js/themes.js"></script>
    <!-- end:javascript -->

</body>
</html> 