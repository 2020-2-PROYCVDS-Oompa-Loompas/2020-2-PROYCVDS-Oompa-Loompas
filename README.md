# 2020-2-PROYCVDS-OOMPA_LOOMPAS

# Integrantes:✒
* Carlos Andrés Amorocho Amorocho
* Juan Carlos Alayón Molina
* Jonathan Fabián Paez Torres
* Jose María Castro Ortega

## Roles:📋

| Nombre | Rol |
| --- | --- |
| Carlos Andrés Amorocho Amorocho | Team Developer |
| Juan Carlos Alayón Molina | Team Developer |
| Jonathan Fabián Paez Torres | Team Developer |
| Jose María Castro Ortega | Team Developer |
| Oscar David Ospina Rodriguez | Product Owner |

## Descripción general 🚀

Esta aplicación tiene como objetivo poder brindar un servicio de información y registro para el laboratorio de Ingeniería de sistemas de la Escuela Colombiana Julio Garavito, donde se puede ver los laboratorios registrados y que equipos están en cada laboratorio con sus respectivos elementos de cada Equipo. Se podrá revisar un historial de novedades que se han realizado durante el tiempo.

## Pagina Web 📦
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://oompa-loompas.herokuapp.com/paginaWeb.xhtml)

## Circle Ci 🔧
[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas)

## Codacy 🔧

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/23d335c474ce4317ad35b19cb90a1f35)](https://app.codacy.com/gh/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/dashboard)

## Información de la base de datos 🛠️

* Anfitrión = ec2-23-20-70-32.compute-1.amazonaws.com
* Base de datos = decigqpg9tb8ia
* Usuario = qcwmpnwwywpfsk
* Puerto = 5432
* Contraseña = c463dede95cbc843ce3298e4af86da6d9286578e8f0a07f93e52967845948c30 

## Diagrama de clases

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/diagramaDeClases.PNG)

## Funcionalidad y/o manual de usuario 🖇️

## MENU BIENVENIDA
Como pagina inicial tendremos el login para iniciar sesión, donde cada usuario ingresara con su usuario y contraseña ya registrado en la base de datos. Dependiendo su rol la página web lo redirigirá a una página web que le ofrecerá ciertas funcionalidades.
A demás se podrá registrar un nuevo usuario.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/pagina.PNG)

## Crear Cuenta
Para poder crear una nueva cuenta es necesario registrar el número de carnet, nombre, correo, contraseña, estado y rol para cada usuario.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/creaUser.PNG)

## Pagina Administrador

En esta página tendrá acceso a las distintas funcionalidades que le ofrece el programa entre ellas podrá: registrar, configurar y obtener un reporte de los laboratorios, equipos, elementos y podrá consultar los usuarios creados.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/pagAdmin.PNG)

## Funcionalidades Laboratorio

Para cada laboratorio usted como usuario podrá: registrar, configurar y obtener un reporte del laboratorio.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/funciLab.PNG)

## Configurar Laboratorios

Si queremos cerrar un laboratorio por cualquier motivo, es necesario colocar su nombre y en seguida se podrá cerrar el laboratorio, para asignar un equipo de igual forma es necesario poner su nombre para que este se pueda vincular correctamente.


![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/confLab.PNG)

## Registrar Laboratorio
Para registrar un laboratorio es necesario su nombre y la capacidad que este va a tener, una vez completados estos datos se puede crear el laboratorio correctamente

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/registroLab.PNG)

## Reporte Laboratorios

Acá podrá encontrar un reporte, el cual analiza las capacidades de cada laboratorio para poder brindar una experiencia mas agradable a la hora de asignar equipos o administrar el laboratorio.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/reporteLab.PNG)

## Funcionalidades Equipos
Para cada equipo usted como usuario podrá: registrar, configurar de igual manera podrá registrar un elemento para poder realizar su respectiva vinculación con un equipo.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/funcEqui.PNG)

## Registrar Equipos
A partir de un nombre único el cual se le asigna a cada equipo, se podrá registrar en la base de datos para su posterior uso.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/registroEqui.PNG)

## Configurar Equipos

En este formulario se podrá dar de baja a un equipo, eliminar su asociación con un laboratorio simplemente seleccionándolo y pulsando sobre el respectivo botón, así mismo podrá asociar, eliminar y dar de baja a los elementos de igual forma seleccionando el elemento y pulsando sobre el respectivo botón.


![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/confEquipos.PNG)

## Registrar Elementos

En este formulario se podrá registrar un elemento colocando su fabricante y la respectiva categoría a la que este pertenece, una vez completados estos datos se podrá registrar pulsando sobre el botón.

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/regiEleme.PNG)

## Historial

En este formulario el usuario podrá consultar el reporte de las novedades que se generan para los equipos y los elementos que sufren una alteración, simplemente pulsando sobre el botón correspondiente.


![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/Historial.PNG)

## Usuarios
En este formulario se podrá consultar lo diferentes usuarios creados con sus respectivos roles.


![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/usuarios.PNG)

## Descripción de Sprints 🛠️
### Sprint 1

![](https://github.com/2020-2-PROYCVDS-Oompa-Loompas/2020-2-PROYCVDS-Oompa-Loompas/blob/main/src/main/webapp/img/graficaTaiga.PNG)

Para el primer Sprint nuestro mayor problema fue que no sabíamos manejar la herramienta de Taiga. No entendiamos como era el funcionamiento y como debíamos distrubuir sus tareas, por ende la gráfica que se muestra es incorrecta, ya que no poniamos las tareas en progreso y tampoco las cerrabamos.
