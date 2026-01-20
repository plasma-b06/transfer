from flask import Flask, render_template, request

app = Flask(__name__)

SPORTS = [ 
    "cricket",
    "football",
    "basketball",
]

REGISTRANTS = {}

@app.route("/")
def index ():
    return render_template("index.html", sports=SPORTS)

@app.route("/register" , methods=["POST"])
def register():
    name = request.form.get("name")
    if not request.form.get("name"):
        return render_template("error.html", message="missing name")
    sports = request.form.get("sport")
    if not sports:
        return render_template("error.html", message="missing sports")
    if sports not in SPORTS:
        return render_template("error.html", message="invalid sports")
    
    REGISTRANTS[name]=sports

    return render_template("success.html")

@app.route("/registrants")
def registrants():
    return render_template("registrants.html", registrants=REGISTRANTS)
