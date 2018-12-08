# Guideline app service

Please provide YAML configuration file in resources to properly run application.

application.yml template:

```
logging:
  level:
    org:
      springframework:
        security: DEBUG
clientId: client
clientSecret: secret
users:
- name: user
  password: password
- name: user1
  password: password1
  etc etc......
```
