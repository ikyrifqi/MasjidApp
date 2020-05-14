<?php

include("config.php");



$sql = "SELECT * FROM identitas_masjid";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'id_identitas' => $row['id_identitas'],
    'nama_masjid' => $row['nama_masjid'],
    'alamat_masjid' => $row['alamat_masjid']
));
}
echo json_encode(array("result" => $result));
?>
