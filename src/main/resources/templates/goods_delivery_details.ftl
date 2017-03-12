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

<div class="table-responsive table-bordered">
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>商品编码</th>
            <th>商品名称</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#if cartList??>
            <#list cartList as cart>
            <tr>
                <td>${cart_index + 1}</td>
                <td>${cart.commodityId}</td>
                <td>${cart.commodityName}</td>
                <td>${cart.num}</td>
                <td><span id="cartGoods_${cart.id}" onclick="delCart(${cart.id})" class="glyphicon glyphicon-minus">&nbsp;</span></td>
            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../js/sb-admin-2.js"></script>

<script>

    function delCart(cartId) {
        $.ajax({
            url: "delCart",
            method: "POST",
            data: { cartId: cartId }
        }).done(function (data) {
            window.location.reload();
        });
    }

</script>

</body>

</html>