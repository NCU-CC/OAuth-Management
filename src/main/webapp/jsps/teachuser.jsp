<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>
                                                                        教學頁面
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#"></i>Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>
                
                <%-- Main content --%>
                <section class="content invoice">

                    
                    <%-- title row --%>
                    <div class="row">
                        <div class="col-xs-12">
                            <h2 class="page-header">
                                <i class="fa fa-user-md"></i> 使用者教學
                                <small class="pull-right">Date: 2/10/2014</small>
                            </h2>
                        </div><%-- /.col --%>
                    </div>
                    <%-- info row --%>
                    <div class="row invoice-info">
                        <div class="col-sm-12 invoice-col">
                                                                                               <strong> 簡介</strong>
                            <address>
                                中央大學民國四年創建於南京，大陸時期為東南的學術重鎮，素有「北北大、南中大」之稱。民國51年在台復校，歷經50年之發展，為國內少數歷史悠久、校景優美、校風淳樸、校譽優良之頂尖研究型大學。 
<br><br>
地處中壢雙連坡的中大，佔地廣達62公頃，扼守著台灣桃園國際機場航空城，距離首善之都台北僅40分鐘車程，鄰近高鐵桃園站，交通便捷。目前學生總人數約一萬三千人，大學生與研究生比例約1：1，為一所中型研究型大學。
<br><br>
目前設有文、理、工、管理、資訊電機、地球科學、客家、生醫理工，共8所學院，22個學系(含理學院不分系學士班)和54個研究所。同時設有8個校屬研究中心及1個聯合研究中心，並設有總教學中心，督導通識教育中心、師資培育中心、語言中心、藝文中心、科學教育中心、出版中心和體育室，是科學、人文薈萃的綜合大學。
<br><br>
中央大學近年來學術表現亮麗，獲選教育部5年500億邁向頂尖大學計畫，歷次考評執行成果均「優」，為台灣高教界進步幅度最大、速度最快的大學之一。
<br><br>
國際的評比上，中大持續進步。除了近年名列上海交通大學的世界大學學術排名前五百大，在英國高等教育調查公司QS的亞洲大學前200名最佳大學排行榜內，本校亦穩健攀升，2012年為第53名。
<br><br>
放眼未來，中央大學將秉持著「誠樸」優良的校風，在既有的基礎上，繼續向下紮根、向上結果，締造更多「中大第一」，並為培育具國際視野、全球關懷的人才而努力，以開創新世紀大學之典範。
<br><br>
                            </address>
                        </div><%-- /.col --%>                        
                    </div><%-- /.row --%>

                   

                    

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
