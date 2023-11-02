# Shift Left

In the early years of software development, applications were typically programmed and tested by the same people. Over the years, organizations started to add more planning and structure to the way they managed the software development lifecycle, breaking it down into concrete phases so that different steps could be handled by different teams. After following this model for a decade or two, many companies began to realize the cost of having the testing phase so late in the lifecycle, and started to shift testing to the left by integrating it into the earlier phases of development.

## Software Development Lifecycle Evolution

- **Waterfall** - The waterfall model comes from industries such as construction and manufacturing, where the cost of materials is a major consideration. In the 1970s, many organizations started to adopt the waterfall model for their software development lifecycle. In this model, a project is broken down into several phases, and progress flows in one direction. Each phase must be complete before the project can move on to the next phase. The waterfall model phases include defining requirements, analysis, design, coding, testing, and deployment. The different phases can be handled by various teams or roles, including product managers, designers, engineering, quality assurance (QA) testing, and user experience (UX). The waterfall model allows for a small amount of overlap between phases. For example, when QA testers find a defect, the developers go back to the engineering phase to fix the defect before moving on to the next phase. Waterfall became the dominant model for software companies during the 1970s and 1980s, and is still used by many organizations.
- **Shorter cycles** - In the mid-1980s, other software development models began to emerge that organized the work into short cycles. For example, the iterative and incremental development model begins with early planning, and the next phase is a repeatable cycle that includes more detailed planning, defining requirements, analysis, design, development, testing, and evaluation. This iterative cycle continues until the application is ready for deployment. In contrast to the waterfall model, the iterative and incremental model allows testing and evaluation to lead to additional planning. Because this model leaves room for major changes to design and implementation while development work is well underway, it lends itself to working on small, incremental parts of an application, and also allows multiple development teams to work on different parts of the application at the same time.
- **Shifting left** - The software development lifecycle continued to evolve through the 1980s, 1990s, and early 2000s, each time placing more emphasis on testing and user feedback. This trend became known as "shifting left" because it moves testing out of its fixed position near the right side of the process diagram and into the earlier phases on the left side. Using the shift-left testing model, tests are run early and often so that bugs and vulnerabilities are found and resolved faster. The shift-left model is more proactive than earlier models because testing focuses on problem prevention throughout the development process rather than problem detection at the end.

## Shift Left Models

- **Traditional** - In the traditional shift-left testing model, also known as the V-model, testing is added to earlier phases of the development lifecycle. For example, user acceptance tests are developed during the initial requirements analysis phase. These tests simulate the way that customers will use the software in production using realistic data, and they are designed to validate that the final product can meet the user's needs. During the system design phase, system test plans are developed to validate that the requirements are met. System testing can include load testing, performance testing, and regression testing. When more detailed design work is done, integration test plans are developed that will verify that the various units of code that make up the software can run together. Finally, during the coding phase, testers develop and run unit tests on the smallest possible modules of the code. Then, testers run the integration tests, system tests, and user acceptance tests that were developed and planned during earlier phases.
- **Incremental Shift Left** - The incremental shift-left testing model takes the traditional V-model and breaks it down into smaller segments of work that can be completed in shorter stretches of time. When developing a large or complex system, an incremental model can be applied to different parts or components of the system. Using an incremental shift-left model allows development teams to code and test different system components at the same time, which means they can verify that the components work together. The incremental model also tends to split phases into smaller steps, such as high-level design and low-level design.
- **Agile Shift Left** - The Agile shift-left model is another evolution of the traditional shift-left model, where the work is divided into sprints. These sprints represent shorter stretches of time than in the incremental model and they run continuously throughout the development lifecycle. Using the Agile model, cross-functional teams stay in close communication with each other while they develop and test smaller components of a single software product. Like earlier shift-left models, Agile is focused on testing early and often, and collaborating with users to get regular feedback. Many teams that use the Agile model also use continuous integration and continuous delivery (CI/CD) tools to automate testing, integrating, and deploying code.
- **Model-based Shift Left** - With model-based shift-left testing, QA testers are involved in the earliest stages of the development lifecycle. Unlike the other shift-left models, testing can begin before any code is written. QA works with product, design, and engineering teams to develop and run tests on the requirements, architecture, and design of the software to identify and prevent potential problems before they occur.

## Why Shift Left?

- **Cost** - Bugs and security vulnerabilities can be expensive to fix. By shifting testing earlier in the development process, testers have more opportunities to identify these issues so that they can be fixed before an application is deployed. Based on a [2020 case study performed by the Ponemon Institute](https://www.ibm.com/account/reg/us-en/signup?formid=urx-46992), a vulnerability costs about $80 to fix during development, while that same vulnerability would cost about $7,600 to fix in production.
- **Speed** - When you include testing in the earlier phases of development, you can identify and resolve issues when they are still small and isolated. By running integration tests, functional tests, and unit tests while development is still in progress, issues can be fixed right away. Developers can use the early feedback from these test results to adapt to changes in requirements or expectations, which saves a significant amount of time compared to making the same changes to a more mature product. Fixing bugs early in the process can also prevent the need for developers to resolve issues in a rush before a product deadline.
- **Automation** - Shifting left can create more opportunities to automate testing. Static code analysis tools, including linters, can check code for programming and style errors without running it, which results in more consistent code. Automated testing leaves less room for human error because the tests are consistent. By integrating automated testing earlier in the CI/CD pipeline, failures appear earlier and can be fixed earlier. When testing is automated, multiple tests can run on the same code at the same time. Automation also requires less time from manual QA testers, which frees them up to work on more valuable tasks.
- **Security** - When testing shifts to the left and the development phase moves more efficiently, code reaches the security analysis phase faster. By the time the code reaches this phase, it has already gone through multiple rounds of testing and many issues have already been resolved. Like other defects, fixing security vulnerabilities as soon as possible saves the most time, effort, and money.

## What Can Shift Left

- **API contracts**
- **Design**
- **Testing**
- **Deployment**
- **Security**
- **IT services**

## How to Start Shifting Left

- **High-level testing strategy** - Define an end-to-end testing strategy that covers the software development lifecycle. As part of this process, evaluate the risk and impact of failure for each test scenario, and decide which team or individual is responsible for each failure that can occur. Developers can begin shifting left by writing a unit test for every new feature they develop.
- **Collaboration across teams** - Development teams should work together to define code standards. Using consistent conventions paves the way for configuring automation to enforce the standards, and it also makes it easier for developers to review each others' code.
- **Scripted configurations** - Configure static testing and linting tools to automatically identify issues early in development. Developers and QA testers configure automated integration tests that run every time new code is merged to the main development branch.
- **Monitoring** - Configure dashboards and tooling that allows developers to see where failures happen at every stage of the lifecycle. When they have insight into failures that occur in production, developers are better equipped to resolve the issues.

## What is Shifting Right?

In addition to shifting more testing to the left in the software development lifecycle, many organizations are also shifting some types of testing to the right. While shift left is about testing early and often, shift right is about testing in production to measure performance.

- **Performance testing** - Operators can monitor how the application behaves in production by looking at logs and metrics. To test performance, they can send additional traffic to the application to see how it behaves under heavier load.
- **Chaos testing** - With chaos testing, testers intentionally introduce issues like errors, network delays, server outages, or missing data. Testers observe how the system attempts to recover from these errors.
- **User experience testing** - Performing usability testing helps give insight about the users' experience with the software. For example, with A/B testing, half of the users see one version of an application (A), and the other half see a different version (B). Testers analyze the users' activity on both versions of the application, and sometimes request direct feedback from the users.
- **Security testing** - Security tests in production can check for vulnerabilities or out-of-date libraries and dependencies. Testers can also run penetration tests to scan an application for security weaknesses.