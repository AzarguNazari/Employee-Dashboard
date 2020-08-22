import {Dashboard, LibraryBooks, MeetingRoom, Notifications, Person} from "@material-ui/icons";
import DashboardPage from "views/Dashboard/Dashboard.js";
import UserProfile from "views/UserProfile/UserProfile.js";
import TableList from "views/TableList/TableList.js";
import Typography from "views/Typography/Typography.js";
import Icons from "views/Icons/Icons.js";
import Maps from "views/Maps/Maps.js";

const dashboardRoutes = [
  {
    path: "/dashboard",
    name: "Dashboard",
    icon: Dashboard,
    component: DashboardPage,
    layout: "/dashboard",
  },
  {
    path: "/user",
    name: "Profile",
    icon: Person,
    component: UserProfile,
    layout: "/dashboard"
  },
  {
    path: "/table",
    name: "Attendence",
    icon: "content_paste",
    component: TableList,
    layout: "/dashboard"
  },
  {
    path: "/typography",
    name: "Tasks",
    icon: LibraryBooks,
    component: Typography,
    layout: "/dashboard"
  },
  {
    path: "/icons",
    name: "Meeting Room",
    icon: MeetingRoom,
    component: Icons,
    layout: "/dashboard"
  },
  {
    path: "/maps",
    name: "Announcements",
    icon: Notifications,
    component: Maps,
    layout: "/dashboard"
  }
];

export default dashboardRoutes;
