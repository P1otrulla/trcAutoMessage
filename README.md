[waka]: https://wakatime.com/badge/user/be67dcc8-512a-42fa-9440-9d76b4a9e8ef/project/97bf5902-8465-42fa-bdb4-f9204ad61985.svg
[version]: https://img.shields.io/badge/version-1.8--1.17-informational

![waka] ![version]

# trcAutoMessage
Plugin na automatyczne wiadmości

### Pliki konfiguracyjne
config.yml
```yaml 
interval: 120

messages:
  1:
    message: "&8» &6Milo cie tu goscic!"

  2:
    message: "&8» &6Sprawdz mojego githuba! &7(KLIK)"
    type: OpenWeb
    action: "https://github.com/Osnixeroo/"
    hover: "&7Kliknij aby przejsc na: &ehttps://github.com/Osnixeroo/"

  3:
    message: "&8» &6Sprawdz aktualne pluginy! &7(KLIK)"
    type: RunCommand
    action: "/plugins"
    hover: "&7Kliknij aby wykonac komende: &e/plugins"
  ```


