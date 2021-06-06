#Meeting Room

Aplicação de um crud de uma Sala de Reunião feita com uma API Rest em Spring Boot com um cliente em Angular.

#### Descrição

Projeto do curso "Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring" do BootCamp Java Developer.

Foi sugerido que fizessemos alguma modificação criativa no projeto original do curso.


implementei a formatação dos dados das pessoas.


Apesar da professora adicionar a dependência lombok não usou na aplicação, eu gosto de como o código fica limpo e usei as annotation disponiveis na classe Model.Room.

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

E não codifiquei os getters, setters e construtores.

A outra modificação foi adicionar um campo de filtragem da salas pelo nome, modifiquei a api-rest e o cliente web para que o usuário pudesse ter essa possibilidade.
