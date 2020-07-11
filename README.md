# Background Services and Card view Applications:
## *AlarmManager Demo project:
Uses AlarmManager to start any activity of the application at particular time.
It also works if application is not existing, and can be used in to initiate activity.
Preffered for only light wieght threads.
It is a part of application lifecycle and will be destroyed after.

## *Foreground and Alarm Demo project:
Uses Foreground for persistent notification generation and also to initiate foreground service only at a particular period of time.
Foreground service are self contained different activity with its own life cycle than the application, so if application itself gets destroyed, forgeround service will run
Should only be used for heavy working thread.

## *My Dashboard:
Uses Card view to represnt the subjects user has enrolled in.
Special features used are a horizontal seekbar converted into circular loading progress bar, which can be have the fill color according to the value you provide from 0-100

## *Timepicker:
Is simple project to show the use of utility of this module
