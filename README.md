

Para ejecutar las pruebas en ambiente local

```bash
cd pruebas
docker-compose up -d
```


Invocar el servicio

```curl
curl -X PUT 'http://localhost:8080/localidades/2332' \
-H 'Content-Type: application/json' \
--data-raw '{
    "nombre": "Tandil",
    "codigoPostal": 7000
}'
```

- [Guías de desarrollo](docs/README.md)
