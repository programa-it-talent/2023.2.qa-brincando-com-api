Funcionalidade: Login via API

    URL:       https://reqres.in
    Endpoint:  /api/login

    Cenario: Login com SUCESSO - SUCESS
        Dado que o usuario possua acesso ao endpoint "/api/login"
        Quando o usuario informar o contrato no corpo da requisicao:
            '{
                "email": "eve.holt@reqres.in",
                "password": "cityslicka"
            }'
        Entao a api retorna o status code '200'
        E a api retorna um token
    
    Cenario: Login com usuario nao cadastrado - SUCESS
        Dado que o usuario possua acesso ao endpoint "/api/login"
        Quando o usuario informar o contrato no corpo da requisicao com email incorreto:
            '{
                "email": "mickhill@hotmail.com",
                "password": "cityslicka"
            }'
        Entao a api retorna o status code '400'
        E a api retorna a mensagem de erro "user not found"

    Cenario: Login com senham invalida - FAILED - BUG
        Dado que o usuario possua acesso ao endpoint "/api/login"
        Quando o usuario informar o contrato no corpo da requisicao:
            '{
                "email": "eve.holt@reqres.in",
                "password": "####"
            }'
        Entao a api retorna o status code '400'
            # Está retornando 200
        E a api retorna a mensagem de erro "senha invalida"
            # Está retornando o token: "QpwL5tke4Pnpja7X4"


