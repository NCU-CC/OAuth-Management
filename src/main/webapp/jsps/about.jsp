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
                                                                        關於我們
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
                                <i class="fa fa-globe"></i> 關於我們
                                <small class="pull-right">Date: 2/10/2014</small>
                            </h2>
                        </div><%-- /.col --%>
                    </div>
                    <%-- info row --%>
                    <div class="row invoice-info">
                        <div class="col-sm-12 invoice-col">
                                                                                               <strong> 簡介</strong>
                            <address>
                                本校電子計算機中心設立於民國六十四年，隸屬於教務處下，其宗旨為提供全校計算機使用環境，促進教學、研究與行政效率。民國七十五年始比照台大改為一級單位，直屬校長督導。 中心設立迄今已滿卅年，在歷任主任的英明領導下，從創設初期，租用IBM 370/125小型計算機、迷你電腦、大型主機、以至全校高速網路骨幹建置，無論是教學區、行政區、研究中心、教職員、學人宿舍以及學生宿舍網路建置均已完成，現今更提供校園內無線上網的優質環境。 在資訊教育推動上亦不遺餘力，早在民國七十年開始即對行政人員開辦資訊教育訓練課程，為推動行政電腦化奠定基石。民國七十五年始更投入人力對大學部新生，實施大一新生計算機概論的實習課程。 在校務行政電腦化方面，以中心有限的人力，自行開發完成電腦選課及分發系統、學籍管理系統與畢業資格審核系統、成績管理系統、招生報名與分發管理系統，未來將整合成教務處整合資訊系統，以達資料共享之目標。另外，亦協助語言中心開發英文能力鑑定考試報名系統，總務處開發物品管理系統，及財產管理系統。 民國七十九年台灣學術網路草創初期，中心即承擔起台灣學術網路桃園區網中心的管理及維運工作，並協助桃園縣、金門縣及連江縣等教育局，建置下連中小學的縣網中心；九十一年獲教育部評鑑為全國十二個區網中心運作績效唯一的特優單位。另外，中心於九十一年及九十二年奉校長授命接辦大學入學分發相關工作，由於時間緊迫且任務目標不容出錯，在舉國矚目下順利圓滿達成校長交付之重任。中心的團隊合作精神及技術人員的專業能力是中大應該珍惜的寶貴資產。 近年來，除了建置完善的硬體設施外，更積極推動校園e化及行政e化的政策，進行中的工作項目有(1) 校務行政資訊系統的開發、(2) 遠距教學平台的建置 (LMS系統)、與(3) 公文流程管理暨電子表單流程管理元件化系統的建置。在中心同仁的努力下，期望除了擁有悠久的傳承外，亦能與時俱進發展中心的各樣特色。
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
