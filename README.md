Creative Commons
Version: 0.1
2021
Gestor de vacunas contra el COVID-19
Willian.a.f
El gestor de vacunas contra el covid-19 es una aplicación estilo consola desarrollada en Java
con las funciones de:
● crear nuevos registros de vacunas
● eliminar registros de vacunas
● buscar un registro de vacuna
● introducir las fases superadas o rechazadas
● autorizar o rechazar una vacuna
● ver vacunas autorizadas o rechazadas y la última fase de investigación de una
vacuna
● Ver todas las vacunas registradas en la aplicación
La aplicación inicialmente contiene un menú con 11 opciones de las cuales son:
1.- Listar todas las vacunas y mostrar todos sus datos.
2.- Buscar vacuna.
3.- Agregar vacuna.
4.- Eliminar vacuna.
5.- Introducir el resultado de las fases de la vacuna.
6.- Autorizar/Rechazar vacuna.
7.- Ver vacunas autorizadas.
8.- Ver vacunas rechazadas.
9.- Ver vacunas pendientes de autorizar/rechazar.
10.-Ver la última fase investigada de cada vacuna almacenada.
11-Salir.
1.-Listar todas las vacunas y mostrar todos sus datos.
Esta opción mostrará todo los registro y los datos de las vacunas
si no hay ninguna vacuna registrada el usuario recibirá un mensaje de error.
y en caso de que haya vacunas registradas se mostrará toda la información de la
misma dependiendo si está autorizada, rechazada y pendiente.
2.-Buscar vacuna.
Para buscar una vacuna es necesario tener el codigo a mano para hacer la
búsqueda correctamente en caso del codigo ser invalido o no tener ninguna vacuna
registrada con este código se mostrará un mensaje de error al usuario.
3.-Agregar vacuna.
La opción agregar vacuna sirve para agregar un nuevo registro de una vacuna
donde será necesario introducir todos los datos cada uno por vez, nombre, principio
activo, farmacéutica, el precio debe ser introducido separado por una coma, al
terminar el registro volvera al menu inicial.
4.-Eliminar vacuna.
Con esta opción podrás eliminar el registro de cualquier vacuna mediante el código
de la vacuna.
5.-Introducir el resultado de las fases de la vacuna.
Aquí será donde se podrá añadir las fases de la vacuna, se podrá elegir cuál fase
quieres informar si ha sido superada o no.
6.-Autorizar/Rechazar vacuna.
La opción 6 es utilizada para autorizar o rechazar una vacuna
en caso que la vacuna no supere alguna de las 3 fases la misma será
rechazada automáticamente, y si se supera las 3 fases podrá ser autorizada
y se cambiara el código.
7.-Ver vacunas autorizadas.
Esta opción podremos ver todas las vacunas que estén registradas como vacunas
autorizadas pudiendo ver sus datos y su precio y la fecha que ha sido autorizada y en
caso de no haber ninguna se enviará un mensaje de error al usuario.
8.- Ver vacunas rechazadas.
Mostrará todas las vacunas que han sido rechazadas y sus datos.
Las vacunas rechazadas o pendientes tiene el código distinto y en el
caso de rechazadas al mostrar por pantalla solo se verá el código, nombre y
principio activo, en caso de no haber ninguna se enviará un mensaje de error
al usuario.
9.-Ver vacunas pendientes de autorizar/rechazar.
Aqui se podrá ver todas las vacunas que no ha sido autorizadas y ni
rechazadas es decir, todas las que aún está en fase de investigación, en
caso de no haber ninguna se enviará un mensaje de error
al usuario.
10.-Ver la última fase investigada de cada vacuna almacenada.
Mediante esta opción podremos ver la última fase de investigación que la vacuna
ha pasado y su resultado en caso de que la vacuna todavía no haya pasado por alguna
fase el resultado será false es decir, si una vacuna supera la primera fase con éxito el
resultado sería :
Última fase superada: 1
fase 1: true
fase 2: false
fase 3: false
eso significa que las dos últimas fases aún están en investigación, y si en el caso que
supere las dos primeras fases con éxito, el valor de “Ultima fase superada” se pondrá a 2
y las dos primeras fases se pasará a true.
11.-Salir.
Esta opción finaliza la aplicación.
