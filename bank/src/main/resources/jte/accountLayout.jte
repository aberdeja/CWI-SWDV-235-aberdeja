@import edu.cwi.UserAccount
@import gg.jte.Content

@param String title
@param Content account
@param Content detail

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background-color: #f4f6f8; display: flex; }
        .sidebar { width: 250px; background: #333; color: #fff; height: 100vh; padding: 20px; box-sizing: border-box; }
        .sidebar h2 { font-size: 1.2rem; margin-bottom: 20px; }
        .sidebar a { display: block; color: #ccc; text-decoration: none; padding: 10px 0; }
        .sidebar a:hover { color: #fff; }
        .main-content { flex: 1; padding: 30px; box-sizing: border-box; }
        .card { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px; }
    </style>
</head>
<body>

    <div class="sidebar">
        <h2>My Account</h2>
        <a href="#profile">Profile</a>
        <a href="#settings">Settings</a>
        <a href="#billing">Billing</a>
        <a href="#logout">Log Out</a>
    </div>

    <div class="main-content">
        <div class="card">
            <h2>Profile Information</h2>
            <p><strong>${account}</strong></p>
            <p><strong>${detail}</strong></p>
        </div>
        <div class="card">
            <h2>Account Settings</h2>
            <p>Manage your password, notifications, and preferences here.</p>
        </div>
    </div>

</body>
</html>