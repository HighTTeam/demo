<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>车载便利店管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Page Content -->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">商品配送</h1>
            <div class="row">
                <div class="col-md-6">
                    <p class="form-control">配送单${distributionId}创建成功！</p>
                </div>
                <div class="col-md-6">&nbsp;</div>
            </div>
            <div class="row"><div class="col-md-3">&nbsp;</div></div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../js/sb-admin-2.js"></script>

<script>
    $('#goodsPlus').on('click', function () {
        $.ajax({
            url: "addCart",
            method: "POST",
            data: { distributionId:"${distributionId}", logicStoreId: $('#storeHouseId').val(), id: $("#goods").val(), num: $("#goods-number").val() }
        }).done(function (data) {
            $('#selected-goods').attr('src', $('#selected-goods').attr('src'));
        });

    });

</script>

</body>

</html>
