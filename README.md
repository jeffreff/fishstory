# Fishstory

- [Fishstory](#fishstory)
  - [What is the project?](#what-is-the-project)
  - [Why am I doing this?](#why-am-i-doing-this)
  - [How did I expect the project to go?](#how-did-i-expect-the-project-to-go)
  - [What went as planned?](#what-went-as-planned)
  - [What could be improved in future revisions?](#what-could-be-improved-in-future-revisions)
  - [Screenshots](#screenshots)
    - [Postman requests & API screenshots (Screenshot headings = URL Resource Path)](#postman-requests--api-screenshots-screenshot-headings--url-resource-path)
      - [findFish & API connection proof](#findfish--api-connection-proof)
      - [findFish](#findfish)
      - [createFish](#createfish)
      - [gutFish](#gutfish)
      - [deleteFish](#deletefish)
    - [Database persistence proof screenshots](#database-persistence-proof-screenshots)
      - [Database before requests](#database-before-requests)
      - [Database after requests](#database-after-requests)
    - [Test results & coverage report screenshots](#test-results--coverage-report-screenshots)
      - [All tests without coverage](#all-tests-without-coverage)
      - [All tests coverage report (Included in documentation folder)](#all-tests-coverage-report-included-in-documentation-folder)
  - [Link to Jira Board](#link-to-jira-board)
  - [Link to GitHub repository](#link-to-github-repository)
  - [Notes](#notes)

## What is the project?

I aim to create the backend (business layer) and database (data layer) of a fishing app/mini-game. The user will be able
to throw a fishing pole and catch a fish. The backend will be created via Java Spring Boot. Caught fish will persist within a MySQL database.

## Why am I doing this?

To entertain the user for a brief amount of time for scenarios such as waiting on public transport and to demonstrate my
current knowledge in software development using Java Spring Boot.

## How did I expect the project to go?

I expected the base project ("must") to be fully implemented before the deadline date and that I could make use of the
remaining time to attempt to implement any "should" and "could" MoSCoW priorities.

## What went as planned?

I fully implemented all the "must" user stories, and I believe I have made use of the Gitflow branching model successfully as well as
implementing appropriate Jira smart commits. I also followed the Agile and Test Driven Development methodologies to the
best of my ability.

## What could be improved in future revisions?

Implement all remaining "should" and "could" user stories left on the Jira board for extra functionality. I had a few
mishaps with merging/pulling incorrectly on GitHub, I have since learnt how to fix these mistakes and plan to take these lessons I
have learnt onwards into future endeavours.

## Screenshots

### Postman requests & API screenshots (Screenshot headings = URL Resource Path)

#### findFish & API connection proof

![findFish & API](documentation/images/findFish%20with%20API%20connection%20proof.png?raw=true)

#### findFish

![findFish](documentation/images/findFish.png?raw=true)

#### createFish

![createFish](documentation/images/createFish.png?raw=true)

#### gutFish

![gutFish](documentation/images/gutFish.png?raw=true)

#### deleteFish

![deleteFish](documentation/images/deleteFish.png?raw=true)

### Database persistence proof screenshots

#### Database before requests

![Database before requests](documentation/images/database%20before%20requests.png?raw=true)

#### Database after requests

![Database after requests](documentation/images/database%20after%20requests.png?raw=true)

### Test results & coverage report screenshots

#### All tests without coverage

![All tests without coverage](documentation/images/all%20tests%20without%20coverage.png?raw=true)

#### All tests coverage report (Included in documentation folder)

![All tests coverage report](documentation/images/all%20tests%20coverage%20report.png?raw=true)

## Link to Jira Board

[Fishstory Jira board](https://jeffreff.atlassian.net/jira/software/projects/FISHSTORY/boards/5)

## Link to GitHub repository

[GitHub repository](https://github.com/jeffreff/fishstory)

## Notes

- MoSCoW expressed in Jira user stories as "Priority" within details panel as well as a tag in epics.
- I am following the Gitflow branching
  model [Read more here:](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).
- I have standardised my Git branches that come off of the development branch with the format: \<author>\_\<branch-type>
  \_\<jira-user-story-issue-number> e.g. "jeffreff_feature_FISHSTORY-5"
- Planned possible development sub-branch types: release, feature, bug, qa.
- I have been unable to fully implement smart commit comments in Jira, as my Atlassian email is different to the GitHub
  email (they must be the same). However, I have followed the "\<Issue> \#comment \<text>" structure in my commit
  comments as best practice. The pushed commits still appear in the details panel however.
- I used a scale of 1-100 for story point estimates.
- MoSCoW is used to split Jira epics into four categories: Must, Should, Could and Won't.
- Test Driven Development was implemented as much as possible during development and testing is not explicitly mentioned
  as subtasks in user stories to prevent unnecessary clutter.
