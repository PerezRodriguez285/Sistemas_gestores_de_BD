$link = mysql_connect('localhost', 'root', 'password');
if (!$link)
   die('Error al conectarse con MySQL: ' . mysql_error().' <br>Número del error: '.mysql_errno());
if (! @mysql_select_db("db_AdMX",$link)){
   echo "No se pudo conectar correctamente con la Base de datos";
   exit();
}

$image = imagecreatefromgif('imagen.gif');
ob_start();
imagegif($image);
$jpg = ob_get_contents();
ob_end_clean();

$jpg = str_replace('##','##',mysql_escape_string($jpg));
$result = mysql_query("INSERT INTO tbl_Banner SET Imagen='$jpg'");

$result = mysql_query("SELECT Imagen FROM tbl_Banner WHERE Id_imagen=11");
$result_array = mysql_fetch_array($result);
header("Content-Type: image/gif");
echo $result_array[0];

