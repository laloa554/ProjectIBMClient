# Proyecto IBM

## Tenologias utilizadas 
  * Spring boot
  * Spring cloud
  * eclipse
  * java 8
  * postgresql

## EndPoints
  * http://localhost:8080/Citibanamex/CreditCardType (Ejercicio 1)
  * http://localhost:8080/SucursalATM/BranchOfficeATM (Ejercicio 2)

## Ejercicio 1.

Se requiere crear un microservicio que dado los inputs
  * Your Passion: Se elige una activadad de las siguientes.
    * shopping
    * travels
    * help
    * myBusiness
    * sports
    * myStyle
  * Monthly Salary: se ingresa el salario mensaual de la persona
  * Age: se ingresa la edad de la persona

Dado estos inputs, el micriservico desarrollado debe responder con las sugerencias de las targetas de credito que puede elegir el usuario.

![image](https://user-images.githubusercontent.com/55073002/137558444-8945d99f-f518-4d11-b860-4538a5450a50.png)

Como se puede ver en la imagen, en el método POST con el endpoint http://localhost:8080/Citibanamex/CreditCardType y en el body los inputs requerdos en formato JSON,
se obtiene una lista de las targetas de credito que se le pueden ofrecer a un cliente de acuerdo a sus necesidades. 

![image](https://user-images.githubusercontent.com/55073002/137558779-e2e2b0cd-8cd5-4e79-9909-046386c1dd46.png)

Cabe resaltar que si estos inputs no cumplen con los requisitos ya establecidos el microservicio regresará un mensaje donde indica que no hay coincidencias como se muestra a continuación:

![noMatches targetas](https://user-images.githubusercontent.com/55073002/137649340-dc5db2b4-5120-437c-86c0-353be6341568.png)

Existe la posibilidad de que falte un input requerido por el microservicio, por lo que en en este caso devolvera un mensaje donde se indica que algo ha salido mal. 

![something is wrong](https://user-images.githubusercontent.com/55073002/137649379-c2337014-7a62-4212-99c7-f397bf2dddb8.png)


## Ejercicio 2

Se requiere un microservicio que dado unas cooredenadas geográficas (GPS), código postal (C.P.), delegación/estado se devuelva una lista de las sucursales o ATM más cercanos. 

Para este ejecicio en particular, decidí tomar las coordenadas geográficas, ya que es una forma mas exacta de conseguir las ubicaciones de las sucursales o ATM. 

Por esta razón, se consume el endpoint http://localhost:8080/SucursalATM/BranchOfficeATM, en su método POST, con la logintud y latitud con formato JSON en el body de la petición.

La información necesaria para que este microsevicio pudiera funcionar correctamente fue tomada de un Json resultante al consumir el siguiente endpoint: 
https://www.banamex.com/localizador/jsonP/json5.json. Este paso, donde se consume el endpoint se confuguró de manera que se guarde en cache y se borre automáticamente cada semana.

Este Json al no ser tan sencillo de manipular, tuve que recurir a limparlo, una vez este proceso esta hecho, se puede buscar cualquier sucursal o ATM con solo ingresar 
la longitud y latitud como se muestra en la siguiente imagén:

![image](https://user-images.githubusercontent.com/55073002/137561183-744d4fa8-1461-4431-af5b-891daa5fe16a.png)

El Output de este microservicio se basa en devolver lo siguiente:
 * street: calle en la que se encuentra.
 * referenceStreet: entre que calles se encuentra
 * brachOfficeATM: tipo de establecimiento (sucursal, ATM u otro)
 * cologne: colonia en la que se encuentra

Cabe resaltar que las coordenadas son exactas, fueron tomadas del json a consumir para realiar las pruebas necesarias. Ya que en un principio se tomó la posibilidad de encontrar todas la sucursales o ATM a 5km a la redonda, pero por razones de tiempo esto no pudo completarse. 

![image](https://user-images.githubusercontent.com/55073002/137561410-1d0d047b-2f2c-49f5-b761-dd7f3dafa87a.png)

finalmente en caso de no encontrar coincidencia alguna, el microservicio regresará un mensaje donde indica que no ha encontrado ninguna coincidencia.

![image](https://user-images.githubusercontent.com/55073002/137649486-20c45fb6-1d32-4621-a678-754eb69a5f60.png)


Nota: Adjunto un archivo sql y una coleccion de postman para las pruebas necesarias.
primero se debera de correr el proyecto **ProjectIBMServer**, al igual que  **ProjectIBMEureka** y finalmente **ProjectIBMClient**
tambien hay un archivo donde se traen las configuraciones con Spring cloud.

 **ProjectIBMServer**: https://github.com/laloa554/ProjectIBMServer.git
 
 **ProjectIBMClient**: https://github.com/laloa554/ProjectIBMClient.git
 
 **ProjectIBMEureka**: https://github.com/laloa554/ProjectIBMEureka.git
 
 **PropertiesIBM**: https://github.com/laloa554/PropertiesIBM.git
