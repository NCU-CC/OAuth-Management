<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- info row --%>
<div class="row invoice-info">
	<div class="col-sm-12 invoice-col">

		<div id="preview">
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">關於開發者使用本系統</h3>
					<small class="pull-right">2015-08-06</small>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>本系統是NCU OAuth的管理介面，讓開發者可以申請及管理<strong>NCU API</strong>的使用。</p>
					<p>開發者所完成的應用程式可放置於中央大學的<a href="http://appstore.cc.ncu.edu.tw/">App Store</a>。</p>
					<p>除了一般自行開發的應用程式外，我們亦提供提案的方式，讓開發者可以開發應用程式給中央大學教職員生使用，並從中獲得工讀費，請參考下方<strong>開發者提案</strong>，程式範例請參考<strong>參考文件</strong></p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">參考文件</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>
						我們所有的服務皆是開源的，包括<a href="https://github.com/NCU-CC/API-Documentation" target="_blank">NCU API</a>，並提供多個app作為使用NCU
						API的範例及其衍生服務。
					</p>
					<p>
						歡迎探索我們的<a href="https://github.com/NCU-CC">程式碼儲存庫</a>及<a
							href="https://play.google.com/store/apps/developer?id=%E5%9C%8B%E7%AB%8B%E4%B8%AD%E5%A4%AE%E5%A4%A7%E5%AD%B8%E9%9B%BB%E5%AD%90%E8%A8%88%E7%AE%97%E6%A9%9F%E4%B8%AD%E5%BF%83"
							target="_blank">Google Play</a>。
					</p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">開發者提案</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>
						針對中央大學的學生，我們提供了提案的管道，讓你可以製作出具創意且適合中央大學教職員生使用的應用服務，並從中得到工讀費；
						其中透過提案完成的作品需使用<strong>MIT License</strong>開源，詳情請參考<a href="http://ncu-cc.github.io/proposal.html">詳細說明</a>。
					</p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
			
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">問題反應</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>我們目前使用<a href="http://open-ncu.slack.com">Slack</a>及<a href="mailto:mobile@cc.ncu.edu.tw">電子郵件</a>作為問題反應的橋樑，使用者及開發者若有任何問題歡迎透過這兩個管道反應。</p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<div class="box box-warning">
				<div class="box-header with-border">
					<h3 class="box-title">API Gateway</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>請儘量使用API Gateway。</p>
					<p>不管您開發的是網站還是智慧型裝置的應用，我們都建議您將client_id、client_secret和api_tokens放置在自己的主機上，並透過這個主機完成呼叫API的工作。
						因為只要它們到了客戶端，無論你使用何種方式保護這些資訊，都還是有可能被客戶端所取得。</p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">使用限制</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>
						每個NCU API皆有每月使用量限制，超過使用量將列入觀察名單，若有特殊需求請<a href="mailto:mobile@cc.ncu.edu.tw">來信</a>告知。
					</p>
					<dl class="dl-horizontal">
						<dt>一般API</dt>
						<dd>每月使用量：25000次 Requests</dd>
						<dt>Personnel-Service</dt>
						<dd>
							每月使用量：25000次 Requests；
							<p class="text-red">一分鐘試誤次數不得超過5次</p>
						</dd>
					</dl>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title">黑名單</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<p>若應用服務被加入黑名單，則該服務的client_id、client_secret和API token將會失效。</p>
					<p>若開發者帳號被加入黑名單，則該帳號將無法登入本系統，及其該開發者所擁有的應用服務也會失效。</p>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
	<%-- /.col --%>

</div>
<%-- /.row --%>
