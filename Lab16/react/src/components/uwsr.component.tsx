import {useEffect, useState} from "react";
import {WsrefListComponent} from "./wsref-list.component";
import {RoleNames} from "../util/role-names";
import axios from "axios";

export function UwsrComponent() {
    let [role, setRole] = useState(RoleNames.GUEST)
    let [password, setPassword] = useState("");
    let [admin, setAdmin] = useState(false);
    let [guest, setGuest] = useState(false);
    const authorize = async () => {
        try {
            await axios.post("", {password});
            setRole(RoleNames.ADMIN);
        } catch (error: any) {
            if (error.response)
                console.error(`Error ${error.response.status}`, error.response.data);
            else throw error;
        }
    }
    const handleKeyPress = (e: KeyboardEvent) => {
        if (e.ctrlKey && e.altKey) {
            switch (e.code) {
                case "KeyA":
                    setAdmin(true);
                    break;
                case "KeyG":
                    setGuest(true);
                    break;
            }
        }
    }
    useEffect(() => {
        window.addEventListener("keydown", handleKeyPress);
        return () => {
            window.removeEventListener("keydown", handleKeyPress);
        };
    }, []);
    return (
        <div>
            <h1>-- UWSR --</h1>
            {admin ? <div>
                <div className={"flex"}>
                    <input name={"password"} value={password} onChange={(e: any) => setPassword(e.target.value)}/>
                </div>
                <div>
                    <button onClick={async (e: any) => {
                        await authorize();
                        setAdmin(false);
                    }}>Set
                    </button>
                    <button onClick={(e: any) => {
                        setRole(RoleNames.GUEST);
                        setAdmin(false);
                    }}>Reset
                    </button>
                </div>
            </div> : null}
            {guest ? <div>
                <div>
                    <button onClick={(e: any) => {
                        setRole(RoleNames.GUEST);
                        setGuest(false);
                    }}>Reset
                    </button>
                </div>
            </div> : null}
            <WsrefListComponent role={role}/>
        </div>
    );
}