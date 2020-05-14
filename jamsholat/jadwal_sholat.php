<?php

include("config.php");



$sql = "SELECT * FROM jadwal_sholat";
$result = array();
$query = mysqli_query($db, $sql);

while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'id_jadwal' => $row['id_jadwal'],
    'dhuha' => $row['dhuha'],
    'shubuh' => $row['shubuh'],
    'dhuhur' => $row['dhuhur'],
    'ashar' => $row['ashar'],
    'maghrib' => $row['maghrib'],
    'isha' => $row['isha'],
    'foto' => $row['foto'],
    'video' => $row['video'],
    'transisi' => $row['transisi']
));
}
echo json_encode(array("result" => $result));
?>
