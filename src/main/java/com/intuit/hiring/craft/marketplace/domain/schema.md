### Database Schema Description

There are three tables in the system: Job, Bid and User

  _____               _____
 |     |             |     |
 | Job |  <---On---  | Bid | 
 |_____|             |_____|

    ^          ^
   / \        /
    |        /
    |      Bids
  Posts    /
    |     /
    |    /
  ______
 |      |
 | User |
 |______|