window.onload = function standardContent (){
document.querySelector('#navigation').innerHTML =
   `<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

   <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="index.html"><img src="CompanyLogo.jpg" width="40px"></a>
   </div>

   <ul class="nav navbar-top-links navbar-right">
       <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#">
               <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
           </a>
           <ul class="dropdown-menu dropdown-user">
               <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
               </li>
               <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
               </li>
               <li class="divider"></li>
               <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
               </li>
           </ul>
       </li>
   </ul>

   <div class="navbar-default sidebar" role="navigation">
       <div class="sidebar-nav navbar-collapse">
           <ul class="nav" id="side-menu">
               <li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>Home</a></li>
               <li><a href="bookings.html"><i class="fa fa-dashboard fa-fw"></i>Booking</a></li>
               <li><a href="tables.html"><i class="fa fa-dashboard fa-fw"></i>Tables</a></li>
               <li><a href="menus.html"><i class="fa fa-dashboard fa-fw"></i>Menus</a></li>
               <li><a href="ingredients.html"><i class="fa fa-dashboard fa-fw"></i>Ingredients</a></li>
               <li><a href="suppliers.html"><i class="fa fa-dashboard fa-fw"></i>Suppliers</a></li>
               <li><a href="extras.html"><i class="fa fa-dashboard fa-fw"></i>Extras</a></li>
           </ul>
       </div>
   </div>
</nav>`
   
}