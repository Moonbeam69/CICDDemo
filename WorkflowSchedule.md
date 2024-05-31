### Workflow execution schedule

|   | Description               | Purpose                    | Branch               | Trigger |
|---|---------------------------|----------------------------|----------------------|---------|
| 1 | CICD_Main_Pipeline        | Main build & test workflow | master               | Push/PR |
| 2 | CICD_Main_Pipeline-4Test  | Build & test workd         | Pipeline_Test_Branch | Push/PR |
| 3 | ScheduledTask             | Dummy nightly build        | N/A                  | Cron [Sun-Thu 00:00] |

