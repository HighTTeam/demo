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
    <div class="row" id="print_ele">
        <div class="col-lg-12">
            <h1 class="page-header">商品入库</h1>
            <form id="delivery-form" action="/" method="POST">
                <div class="row">
                    <div class="col-md-6">
                        <label class="control-label" for="distributionId">入库单号：<div hidden>${distributionId}</div></label>
                        <input type="text" class="form-control" id="distributionId" name="distributionId"
                               value="${distributionId}" readonly>
                    </div>
                    <div class="col-md-6">&nbsp;</div>
                </div>
                <div class="row">
                    <div class="col-md-3">&nbsp;</div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <label class="control-label" for="storeHouseId">仓库名：</label>
                        <select class="form-control" id="storeHouseId">
                        <#list storeHouses as storeHouse>
                            <option value="${storeHouse.id}">${storeHouse.name}</option>
                        </#list>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <label class="control-label" for="wholesalerHead">批发商负责人：</label>
                        <input class="form-control" id="wholesalerHead" name="wholesalerHead" type="text">&nbsp;&nbsp;
                    </div>
                    <div class="col-md-6">&nbsp;</div>
                </div>
                <div class="row">
                    <div class="col-md-3">&nbsp;</div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <label class="control-label" for="motorcadeHead">车队负责人：</label>
                        <input class="form-control" id="motorcadeHead" name="motorcadeHead" type="text">&nbsp;&nbsp;
                    </div>
                    <div class="col-md-3">
                        <label class="control-label" for="storeHeadInput">入仓负责人：</label>
                        <input class="form-control" id="storeHeadInput" name="storeHeadInput" type="text">&nbsp;&nbsp;
                    </div>
                    <div class="col-md-6"></div>
                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                </div>
                <div class="row no-print">
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
                    <div class="col-md-4">
                    </div>
                    <div class="col-md-2 text-right">
                        <button type="button" id="confirm-delivery" style="margin-top: 25px;"
                                class="btn btn-success btn-block">确认配送
                        </button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">&nbsp;</div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">已选商品</div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <iframe id="selected-goods"
                                        style="width: 100%; height: auto; min-height: 300px;"
                                        frameborder="0"
                                        src="/delivery_details?distributionId=${distributionId}"></iframe>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                    </div>
                    <div class="col-md-4">&nbsp;</div>
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


<!-- Modal -->
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                配送单${distributionId}创建成功！
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="print-delivery">打印配送单</button>
            </div>
        </div>
    </div>
</div>


<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../js/sb-admin-2.js"></script>
<script src="../js/jQuery.print.js"></script>

<script>
    $('#goodsPlus').on('click', function () {
        $.ajax({
            url: "addCart",
            method: "POST",
            data: {
                distributionId: "${distributionId}",
                logicStoreId: $('#storeHouseId').val(),
                vehicleStoreId: "demo",
                id: $("#goods").val(),
                num: $("#goods-number").val()
            }
        }).done(function (data) {
            $('#selected-goods').attr('src', $('#selected-goods').attr('src'));
        });

    });

    $('#confirm-delivery').on('click', function () {
        if ($.isEmptyObject($("#wholesalerHead").val())) {
            $("#wholesalerHead").focus();
            alert("请输入批发商负责人");
        } else if ($.isEmptyObject($("#motorcadeHead").val())) {
            $("#motorcadeHead").focus();
            alert("请输入车队负责人");
        } else if ($.isEmptyObject($("#storeHeadInput").val())) {
            $("#storeHeadInput").focus();
            alert("请输入仓库负责人");
        } else {
            $.ajax({
                url: "godownEntryConfirm",
                method: "POST",
                data: {
                    distributionId: "${distributionId}",
                    wholesalerHead: $("#wholesalerHead").val(),
                    motorcadeHead: $("#motorcadeHead").val(),
                    storeHeadInput: $("#storeHeadInput").val()
                }
            }).done(function (data) {
                $('#confirmModal').modal('show');
            });
        }

    });

    $('#confirmModal').on('hidden.bs.modal', function () {
        window.location.reload();
    });

    $('#print-delivery').on('click', function () {
        $("#print_ele").print();
    });

</script>

</body>

</html>
