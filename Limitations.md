### Limitations

|   | Description                                              | Mitigation                                                        |
|---|----------------------------------------------------------|-------------------------------------------------------------------|
| 1 | Cannot run Safari tests on Linux                         | Webkit is supported                                               |
| 2 | Browserstack eval license only supports Win/Chromium     | Buy license                                                       |
| 3 | Matrix strategy auto-combines                            | Care must be taken that all target environments support the tests |
| 4 | Installtion of Maven is not managed through the workflow | Can be managed in the same way as Java is managed                 |
