<?php
session_start();
$id  = $_GET['id'];


echo $id;

$_SESSION['cart'] = $_SESSION['cart'] . $id. ' ' ;

echo 'Current Items: ';
echo $_SESSION['cart'];

echo'<script> window.location=”view_products.php”; </script>'; 

?>
