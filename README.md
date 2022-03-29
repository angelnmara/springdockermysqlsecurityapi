Aplicacion que integra sprign, mysql, seguridad dentro de un docker.

1.- Creas la red donde va estar tu BD y tu docker de java
sudo docker network create employee-mysql

2.- Creas tu instancia base de datos:
sudo docker run \
    --network employee-mysql\
    --name mysql1 \
    -p 3306:3306 \
    -v mysql-8-data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=maradr -e MYSQL_USER=root -e MYSQL_DATABASE=test \
    --restart always \
    -d mysql:8.0 \
    
3.- Tienes que accesar a tu instancia y crear la base de datos, puedes hacerlo desde codigo o bien con cualquier entorno grafico ej. DBeaver.
sudo docker exec -it mysql1 bash
mysql -uroot -p

* la ultima vez me dio problemas con ese passw lo tuve que cambiar.
    
4.- Generas la imagen de tu docker:
docker build -t javadbapp .

5.- Ejecutas el docker:
docker run  --network employee-mysql -p 81:8080 javadbapp &!

6.- Si tu base de datos esta arriba, levantara el docker sin problemas, en la configuracion bienen 2 cadenas de conexion, la que dice produccion apunta hacia el docker y la de pruebas apunta local, para levantar el docker tiene que estar en modo produccion, si no estaba asi y lo cambiaste, recuerda que tienes que generar la imagen de nueva cuenta y volverlo a ejecutar, puedes probar que los 2 esten arriba con el comando:
docker ps

igual con este comando puedes ver a donde estan apuntando, por default la base de datos esta en el 3306 y la aplicacion esta en el puerto 81

igual si se te olvido cambiarle la conexion y esta arriba recuerda que tienes que parar el contenedor y borrarlo
docker rm -f docker-id

happy programing
"# proyectointegrador" 
