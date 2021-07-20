Creative Commons<br>
Version: 0.1<br>
año: 2021<br>
Gestor de vacunas contra el COVID-19<br>
<strong>Willian.a.f</strong><br>
El gestor de vacunas contra el covid-19 es una aplicación estilo consola desarrollada en Java<br>
con las funciones de:<br>
● crear nuevos registros de vacunas<br>
● eliminar registros de vacunas<br>
● buscar un registro de vacuna<br>
● introducir las fases superadas o rechazadas<br>
● autorizar o rechazar una vacuna<br>
● ver vacunas autorizadas o rechazadas y la última fase de investigación de una<br>
vacuna<br>
● Ver todas las vacunas registradas en la aplicación<br>
La aplicación inicialmente contiene un menú con 11 opciones de las cuales son:<br>
1.- Listar todas las vacunas y mostrar todos sus datos.<br>
2.- Buscar vacuna.<br>
3.- Agregar vacuna.<br>
4.- Eliminar vacuna.<br>
5.- Introducir el resultado de las fases de la vacuna.<br>
6.- Autorizar/Rechazar vacuna.<br>
7.- Ver vacunas autorizadas.<br>
8.- Ver vacunas rechazadas.<br>
9.- Ver vacunas pendientes de autorizar/rechazar.<br>
10.-Ver la última fase investigada de cada vacuna almacenada.<br>
11-Salir.<br>

1.-Listar todas las vacunas y mostrar todos sus datos.<br>
Esta opción mostrará todo los registro y los datos de las vacunas<br>
si no hay ninguna vacuna registrada el usuario recibirá un mensaje de error.<br>
y en caso de que haya vacunas registradas se mostrará toda la información de la<br>
misma dependiendo si está autorizada, rechazada y pendiente.<br>

2.-Buscar vacuna.<br>
Para buscar una vacuna es necesario tener el codigo a mano para hacer la<br>
búsqueda correctamente en caso del codigo ser invalido o no tener ninguna vacuna<br>
registrada con este código se mostrará un mensaje de error al usuario.<br>

3.-Agregar vacuna.<br>
La opción agregar vacuna sirve para agregar un nuevo registro de una vacuna<br>
donde será necesario introducir todos los datos cada uno por vez, nombre, principio<br>
activo, farmacéutica, el precio debe ser introducido separado por una coma, al<br>
terminar el registro volvera al menu inicial.<br>

4.-Eliminar vacuna.<br>
Con esta opción podrás eliminar el registro de cualquier vacuna mediante el código<br>
de la vacuna.<br>

5.-Introducir el resultado de las fases de la vacuna.<br>
Aquí será donde se podrá añadir las fases de la vacuna, se podrá elegir cuál fase<br>
quieres informar si ha sido superada o no.<br>

6.-Autorizar/Rechazar vacuna.<br>
La opción 6 es utilizada para autorizar o rechazar una vacuna<br>
en caso que la vacuna no supere alguna de las 3 fases la misma será<br>
rechazada automáticamente, y si se supera las 3 fases podrá ser autorizada<br>
y se cambiara el código.<br>

7.-Ver vacunas autorizadas.<br>
Esta opción podremos ver todas las vacunas que estén registradas como vacunas<br>
autorizadas pudiendo ver sus datos y su precio y la fecha que ha sido autorizada y en<br>
caso de no haber ninguna se enviará un mensaje de error al usuario.<br>

8.- Ver vacunas rechazadas.<br>
Mostrará todas las vacunas que han sido rechazadas y sus datos.<br>
Las vacunas rechazadas o pendientes tiene el código distinto y en el<br>
caso de rechazadas al mostrar por pantalla solo se verá el código, nombre y<br>
principio activo, en caso de no haber ninguna se enviará un mensaje de error<br>
al usuario.<br>

9.-Ver vacunas pendientes de autorizar/rechazar.<br>
Aqui se podrá ver todas las vacunas que no ha sido autorizadas y ni<br>
rechazadas es decir, todas las que aún está en fase de investigación, en<br>
caso de no haber ninguna se enviará un mensaje de error<br>
al usuario.<br>

10.-Ver la última fase investigada de cada vacuna almacenada.<br>
Mediante esta opción podremos ver la última fase de investigación que la vacuna<br>
ha pasado y su resultado en caso de que la vacuna todavía no haya pasado por alguna<br>
fase el resultado será false es decir, si una vacuna supera la primera fase con éxito el<br>
resultado sería :<br>
Última fase superada: 1<br>
fase 1: true<br>
fase 2: false<br>
fase 3: false<br>
eso significa que las dos últimas fases aún están en investigación, y si en el caso que<br>
supere las dos primeras fases con éxito, el valor de “Ultima fase superada” se pondrá a 2<br>
y las dos primeras fases se pasará a true.<br>

11.-Salir.<br>
Esta opción finaliza la aplicación.<br>
