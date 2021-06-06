#Meeting Room

Aplicação de um crud de uma Sala de Reunião feita com uma API Rest em Spring Boot com um cliente em Angular.

#### Descrição

Projeto do curso "Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring" do BootCamp Java Developer.

Foi sugerido que fizessemos alguma modificação criativa no projeto original do curso.


implementei a formatação dos dados das pessoas.


Foram criados uma nova classe (PersonFormattedResponseDTO), um novo método  (toFormattedString) e uma nova chamada rest (@GetMapping("/formatted")).


A classe PersonFormattedResponseDTO recebe uma lista de string para apresentar como resultado do findAll, nela concatenei o firstName e lastName, além de fazer alguns ajustes.


A modificação não foi muito expressiva, mas serviu para mostrar que absorvi o conteúdo do curso.
