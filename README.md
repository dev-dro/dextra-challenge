# Instruções para executar

## Backend
Necessário ter um JDK instalado.
Rodar o script `mvnw` ou `mvnw.cmd` se for windows.


## Frontend
Necessário ter o nodejs e o npm instalado.
Executar o seguinte comando dentro da pasta frontend:
`npm install && npm start`.

# Tecnologias utilizadas
O backend foi feito utilizando Java com Spring Boot e Rest. Não tem um motivo técnico específico para ter usado essa stack para essa demonstração, apenas foi me pedido. Foram utilizadas técnicas de herança e composição para reduzir a duplicação de código.

O front end foi feito em angular pois é o framework que tenho mais experiência. Também foi usado bootstrap como framework css.

O backend da aplicação já está preparado para executar bem mais funções do que estão disponíveis no front (cadastrar e remover itens do cardápio, cadastrar e remover ingredientes, etc.) mas não as consegui implementar no frontend a tempo (inclusive me enrolei bem mais do que deveria por causa disso, devia ter priorizado os requisitos para terminar a tempo).
