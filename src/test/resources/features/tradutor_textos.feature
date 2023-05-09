# language: pt

@funcionais
Funcionalidade: Tradutor de textos
  Como um tradutor
  Quero tradudiz textos de espanhol para portugues
  Para criar documentos multiligues acessivel para qualquer tipo de pessoal

  Contexto: Acessar Pagina Inicial do Deepl Translator
    Dado que o usuario acessa a pagina inicial do Deepl Translator

  @espanhol
  Cenario: Tradução de texto no idioma Portugues para Espanhol
    Dado que usuario possui um texto em idioma portugues
    Quando ele solicita a traducao do texto para o idioma em espanhol
    Entao o sistema deve exibir a traducao do texto corretamente

  @idiomas
  Esquema do Cenario: Tradução de varios idiomas
    Dado que usuario possui o texto "O teste automatizado aumentar a qualidade e confiabilidade no desenvolvimento de software." em idioma portugues
    Quando ele solicita a traducao do texto para o idioma em "<idioma>"
    Entao o sistema deve exibir o texto traduzido "<traducao>" corretamente

    Exemplos:
      | idioma              | traducao                                                                                     |
      | inglês (americano)  | Automated testing increases qualit and reliability in software development.                  |
      | italiiano           | I test automatizzati aumentano la qualità e l'affidabilità dello sviluppo del software.      |
      | francês             | Les tests automatisés augmentent la qualité etx la fiabbilité du développement de logiciels. |
      | alemão              | Automatisierte Tests erhöhen die Qualität und Zuvverlässigkeit der Softwareentwicklung.      |