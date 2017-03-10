<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

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
                            <div class="col-md-3">
                                <label for="store-house">仓库：</label>
                                <select id="store-house">
                                    <#list storeHouses as storeHouse>
                                        <option>${storeHouse}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="vehicle-store">车库：</label>
                                <select id="vehicle-store">
                                <#list vehicleStores as vehicleStore>
                                    <option>${vehicleStore}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-md-6">&nbsp;</div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="goods">商品：</label>
                                <select id="goods">
                                <#list goodsList as goods>
                                    <option>${goods}</option>
                                </#list>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="goods-number">数量：</label>
                                <input type="number" id="goods-number">&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-plus">&nbsp;</span>
                            </div>
                            <div class="col-md-6">&nbsp;</div>
                        </div>
                        <div class="row">
                            <div class="col-md-8">
                                <div class="panel panel-default">
                                    <div class="panel-heading">已选商品</div>
                                    <!-- /.panel-heading -->
                                    <div class="panel-body">
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
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                    <td><span class="glyphicon glyphicon-minus">&nbsp;</span></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                    <td><span class="glyphicon glyphicon-minus">&nbsp;</span></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                    <td><span class="glyphicon glyphicon-minus">&nbsp;</span></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                            </div>
                            <div class="col-md-4">&nbsp;</div>
                        </div>
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

</body>

</html>
