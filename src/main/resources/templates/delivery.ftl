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
            <form id="delivery-form" action="/delivery_confirm" method="POST">
            <div class="row">
                <div class="col-md-6">
                    <label class="control-label" for="distributionId">配送单号：</label>
                    <input type="text" class="form-control" id="distributiond" name="distributionId" value="${distributionId}" readonly>
                </div>
                <div class="col-md-6">&nbsp;</div>
            </div>
                <div class="row"><div class="col-md-3">&nbsp;</div></div>
            <div class="row">
                <div class="col-md-3">
                    <label class="control-label" for="storeHouseId">配送点：</label>
                    <select class="form-control" id="storeHouseId">
                    <#list storeHouses as storeHouse>
                        <option value="${storeHouse.id}">${storeHouse.name}</option>
                    </#list>
                    </select>
                </div>
                <div class="col-md-3">
                    <label class="control-label" for="vehicleStoreId">车载便利店：</label>
                    <select class="form-control" id="vehicleStoreId" name="vehicleStoreId">
                    <#list vehicleStores as vehicleStore>
                        <option value="${vehicleStore.id}">${vehicleStore.name}</option>
                    </#list>
                    </select>
                </div>
                <div class="col-md-6">&nbsp;</div>
            </div>
            <div class="row"><div class="col-md-3">&nbsp;</div></div>
            <div class="row">
                <div class="col-md-3">
                    <label class="control-label" for="goods">商品：</label>
                    <select class="form-control" id="goods">
                    <#list goodsList as goods>
                        <option value="${goods.id}">${goods.name}</option>
                    </#list>
                    </select>
                </div>
                <div class="col-md-3">
                    <label class="control-label" for="goods-number">数量：</label>
                    <div class="input-group">
                        <input class="form-control" type="number" min="1" value="1" id="goods-number">
                        <span class="input-group-btn">
                        <button type="button" id="goodsPlus" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>
                        </span>
                    </div>
                </div>
                <div class="col-md-3">
                </div>
                <div class="col-md-1 text-right">
                    <button type="submit" id="confirm-delivery" style="margin-top: 25px;" class="btn btn-success btn-block">确认配送</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">已选商品</div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <iframe id="selected-goods"
                                    style="width: 100%; height: auto; min-height: 300px;"
                                    frameborder="0" src="/delivery_details?distributionId=${distributionId}"></iframe>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <div class="col-md-4">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label col-md-5" for="store-head-output">出仓负责人：</label>
                    <div class="col-md-8">
                        <input class="form-control" id="stockOutName" name="stockOutName" type="text" id="store-head-output">&nbsp;&nbsp;
                    </div>
                </div>
                </div>
                <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label col-md-5" for="store-head-input">入仓负责人：</label>
                    <div class="col-md-8">
                        <input class="form-control" id="stockInName" name="stockInName" type="text" id="store-head-input">&nbsp;&nbsp;
                    </div>
                </div>
                </div>
            </div>
            </form>
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