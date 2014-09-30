<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"></jsp:include>
        <!-- start:main -->
        <div class="container">
            <div id="main">
                <!-- start:breadcrumb -->
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Oauth</a></li>
                    <li class="active">Authorized Applications</li>
                </ol>
                <!-- end:breadcrumb -->

                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="page-header">
                            Authorized applications
                        </h2>
                    </div>
                </div>
                
                <!-- start:basic table -->
                 
                
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Advanced Table
                            </header>
                            <table class="table table-striped table-advance table-hover">
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> Application</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Permission</th>
                                        <th><i class="fa fa-bookmark"></i> Time</th>
										<th></th>
                                        <th><i class=" fa fa-edit"></i> Operation</th>                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><a href="#">Bitnami</a></td>
                                        <td class="hidden-phone">user:email</td>
                                        <td>Last used on August 05, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#">
                                                CloudBees
                                            </a>
                                        </td>
                                        <td class="hidden-phone">public_repo, user:email</td>
                                        <td>Last used on August 04, 2014 </td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#">
                                                Coveralls
                                            </a>
                                        </td>
                                        <td class="hidden-phone">user:email</td>
                                        <td>Last used on July 27, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#">
                                                GitLab Cloud
                                            </a>
                                        </td>
                                        <td class="hidden-phone">user:email</td>
                                        <td>Last used on September 17, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="#">Google Cloud Platform</a></td>
                                        <td class="hidden-phone">repo</td>
                                        <td>Last used on June 11, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="#">
                                                Travis CI
                                            </a>
                                        </td>
                                        <td class="hidden-phone">read:org, repo:status, repo_deployment, user:email, write:repo_hook</td>
                                        <td>Last used on September 18, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><a href="#">Travis CI Pro</a></td>
                                        <td class="hidden-phone">repo, user:email</td>
                                        <td>Last used on September 19, 2014</td>
                                        <td></td>
                                        <td>
                                            <span class="label label-danger label-mini">revoke</span>
                                        </td>
                                    </tr>                                    
                                </tbody>
                            </table>
                        </section>
                    </div>
                </div>
                <!-- end:basic table -->

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